/*******************************************************************************
 * Copyright (c) 2009, 2015 Mateusz Matela and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Mateusz Matela - initial API and implementation
 *               Ian Bull
 ******************************************************************************/
package org.eclipse.gef4.layout.listeners;

import org.eclipse.gef4.layout.IConnectionLayout;
import org.eclipse.gef4.layout.ILayoutAlgorithm;
import org.eclipse.gef4.layout.ILayoutContext;
import org.eclipse.gef4.layout.INodeLayout;

/**
 * An {@link IGraphStructureListener} is notified about structural changes, i.e.
 * the addition/removal of {@link INodeLayout}s and {@link IConnectionLayout}s.
 */
public interface IGraphStructureListener {

	/**
	 * A stub implementation of the {@link IGraphStructureListener} which
	 * contains empty implementations of the specified methods.
	 */
	public class Stub implements IGraphStructureListener {

		public boolean nodeAdded(ILayoutContext context, INodeLayout node) {
			return false;
		}

		public boolean nodeRemoved(ILayoutContext context, INodeLayout node) {
			return false;
		}

		public boolean connectionAdded(ILayoutContext context,
				IConnectionLayout connection) {
			return false;
		}

		public boolean connectionRemoved(ILayoutContext context,
				IConnectionLayout connection) {
			return false;
		}
	}

	/**
	 * This method is called whenever a node is added to a context. No separate
	 * events will be fired for eventual connections adjacent to the added node.
	 * 
	 * If true is returned, it means that the receiving listener has intercepted
	 * this event. Intercepted events will not be passed to the rest of the
	 * listeners. If the event is not intercepted by any listener,
	 * {@link ILayoutAlgorithm#applyLayout(boolean)} will be called on the
	 * context's main algorithm.
	 * 
	 * @param context
	 *            the layout context that fired the event
	 * @param node
	 *            the added node
	 * @return <code>true</code> if no dynamic layout should be applied
	 *         afterwards.
	 */
	public boolean nodeAdded(ILayoutContext context, INodeLayout node);

	/**
	 * This method is called whenever a node is removed from a context. No
	 * separate events will be fired for eventual connections adjacent to the
	 * removed node. If <code>true</code> is returned, no dynamic layout will be
	 * applied after notifying all listeners, i.e. a dynamic layout pass will
	 * only be applied when all registered {@link IGraphStructureListener}s
	 * return <code>false</code>.
	 * 
	 * @param context
	 *            the context that fired the event
	 * @param node
	 *            the removed node
	 * @return <code>true</code> if no dynamic layout should be applied
	 *         afterwards.
	 */
	public boolean nodeRemoved(ILayoutContext context, INodeLayout node);

	/**
	 * This method is called whenever a connection is added to a context. It can
	 * be assumed that both source and target nodes of the added connection
	 * already exist in the context.
	 * <p>
	 * This method will be called only if both nodes connected by added
	 * connection lay directly in the node container owned by the notifying
	 * layout context.
	 * <p>
	 * If <code>true</code> is returned, no dynamic layout will be applied after
	 * notifying all listeners, i.e. a dynamic layout pass will only be applied
	 * when all registered {@link IGraphStructureListener}s return
	 * <code>false</code>.
	 * 
	 * @param context
	 *            the context that fired the event
	 * @param connection
	 *            the added connection
	 * @return <code>true</code> if no dynamic layout should be applied
	 *         afterwards.
	 */
	public boolean connectionAdded(ILayoutContext context,
			IConnectionLayout connection);

	/**
	 * This method is called whenever a connection is removed from a context. It
	 * can be assumed that both source and target nodes of the removed
	 * connection still exist in the context and will not be removed along with
	 * it.
	 * <p>
	 * This method will be called only if both nodes connected by removed
	 * connection lay directly in the node container owned by the notifying
	 * layout context.
	 * <p>
	 * If <code>true</code> is returned, no dynamic layout will be applied after
	 * notifying all listeners, i.e. a dynamic layout pass will only be applied
	 * when all registered {@link IGraphStructureListener}s return
	 * <code>false</code>.
	 * 
	 * @param context
	 *            the context that fired the event
	 * @param connection
	 *            the added connection
	 * @return <code>true</code> if no dynamic layout should be applied
	 *         afterwards.
	 */
	public boolean connectionRemoved(ILayoutContext context,
			IConnectionLayout connection);

}
