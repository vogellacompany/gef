/*******************************************************************************
 * Copyright (c) 2016 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthias Wienand (itemis AG) - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.gef4.mvc.tests.stubs;

import org.eclipse.gef4.mvc.parts.AbstractRootPart;
import org.eclipse.gef4.mvc.parts.IVisualPart;

public class RootPart extends AbstractRootPart<Object, Object> {
	@Override
	protected void addChildVisual(IVisualPart<Object, ? extends Object> child, int index) {
	}

	@Override
	protected Object createVisual() {
		return this;
	}

	@Override
	protected void doRefreshVisual(Object visual) {
	}

	@Override
	protected void removeChildVisual(IVisualPart<Object, ? extends Object> child, int index) {
	}
}