/*******************************************************************************
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Nyßen (itemis AG) - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.gef4.mvc.fx.behaviors;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.transform.Affine;

import org.eclipse.gef4.geometry.planar.AffineTransform;
import org.eclipse.gef4.mvc.behaviors.AbstractBehavior;
import org.eclipse.gef4.mvc.fx.parts.FXRootPart;
import org.eclipse.gef4.mvc.models.ViewportModel;
import org.eclipse.gef4.mvc.parts.IRootPart;

public class FXViewportBehavior extends AbstractBehavior<Node> implements
		PropertyChangeListener {

	protected FXRootPart rootPart;
	protected final Affine contentsTx = new Affine();
	private ViewportModel viewportModel;
	private final ChangeListener<Number> translateXListener = new ChangeListener<Number>() {
		@Override
		public void changed(ObservableValue<? extends Number> observable,
				Number oldValue, Number newValue) {
			viewportModel.setTranslateX(newValue.doubleValue());
		}
	};
	private final ChangeListener<Number> translateYListener = new ChangeListener<Number>() {
		@Override
		public void changed(ObservableValue<? extends Number> observable,
				Number oldValue, Number newValue) {
			viewportModel.setTranslateY(newValue.doubleValue());
		}
	};

	@Override
	public void activate() {
		super.activate();
		IRootPart<Node, ? extends Node> root = getHost().getRoot();
		if (!(root instanceof FXRootPart)) {
			throw new IllegalStateException(
					"MVC IRootPart has to be an FXRootPart!");
		}
		rootPart = (FXRootPart) root;
		viewportModel = rootPart.getViewer().getAdapter(ViewportModel.class);
		viewportModel.addPropertyChangeListener(this);

		// TODO: move to adapter within rootpart
		rootPart.getScrollPane().getCanvas().translateXProperty()
				.addListener(translateXListener);
		rootPart.getScrollPane().getCanvas().translateYProperty()
				.addListener(translateYListener);
	}

	protected void applyViewport(double translateX, double translateY,
			double width, double height, AffineTransform contentsTransform) {
		rootPart.getScrollPane().setScrollOffsetX(translateX);
		rootPart.getScrollPane().setScrollOffsetY(translateY);
		rootPart.getScrollPane().setPrefWidth(width);
		rootPart.getScrollPane().setPrefHeight(height);
		setTx(contentsTx, contentsTransform);
		rootPart.getScrollPane().setViewportTransform(contentsTx);
	}

	@Override
	public void deactivate() {
		viewportModel.removePropertyChangeListener(this);
		rootPart.getScrollPane().getCanvas().translateXProperty()
				.removeListener(translateXListener);
		rootPart.getScrollPane().getCanvas().translateYProperty()
				.removeListener(translateYListener);
		super.deactivate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (ViewportModel.VIEWPORT_TRANSLATE_X_PROPERTY.equals(evt
				.getPropertyName())
				|| ViewportModel.VIEWPORT_TRANSLATE_Y_PROPERTY.equals(evt
						.getPropertyName())
				|| ViewportModel.VIEWPORT_WIDTH_PROPERTY.equals(evt
						.getPropertyName())
				|| ViewportModel.VIEWPORT_HEIGHT_PROPERTY.equals(evt
						.getPropertyName())
				|| ViewportModel.VIEWPORT_CONTENTS_TRANSFORM_PROPERTY
						.equals(evt.getPropertyName())) {
			applyViewport(viewportModel.getTranslateX(),
					viewportModel.getTranslateY(), viewportModel.getWidth(),
					viewportModel.getHeight(),
					viewportModel.getContentsTransform());
		}
	}

	protected void setTx(Affine tx, AffineTransform at) {
		double[] m = at.getMatrix();
		tx.setMxx(m[0]);
		tx.setMxy(m[1]);
		tx.setMyx(m[2]);
		tx.setMyy(m[3]);
		tx.setTx(m[4]);
		tx.setTy(m[5]);
	}

}
