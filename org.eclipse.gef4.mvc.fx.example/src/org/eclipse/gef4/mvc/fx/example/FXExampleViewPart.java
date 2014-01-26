package org.eclipse.gef4.mvc.fx.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.embed.swt.FXCanvas;

import org.eclipse.gef4.geometry.planar.BezierCurve;
import org.eclipse.gef4.geometry.planar.CurvedPolygon;
import org.eclipse.gef4.geometry.planar.ICurve;
import org.eclipse.gef4.geometry.planar.IGeometry;
import org.eclipse.gef4.geometry.planar.IShape;
import org.eclipse.gef4.geometry.planar.Line;
import org.eclipse.gef4.geometry.planar.PolyBezier;
import org.eclipse.gef4.geometry.planar.Rectangle;
import org.eclipse.gef4.mvc.fx.domain.FXEditDomain;
import org.eclipse.gef4.mvc.fx.viewer.FXViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class FXExampleViewPart extends ViewPart {

	public class ExampleGeometricModel {

		private IShape s1 = new Rectangle(50, 50, 50, 50);
		private IShape s2 = new Rectangle(150, 50, 50, 50);
		private ICurve c1 = new Line(100, 75, 150, 75);

		private IShape createGTopShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(27, 193, 35, 191));
			segments.add(new Line(35, 191, 36, 180));
			segments.add(new Line(36, 180, 47, 180));
			segments.add(new Line(47, 180, 51, 168));
			segments.add(new Line(51, 168, 62, 169));
			segments.add(new Line(62, 169, 66, 157));
			segments.add(new Line(66, 157, 78, 159));
			segments.add(new Line(78, 159, 81, 150));
			segments.add(new Line(81, 150, 79, 146));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(79, 146,
					67, 151, 41, 170, 28, 185, 27, 193).toBezier()));
			return new CurvedPolygon(segments);
		}

		private IShape createGBaseShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(27, 197, 37, 196));
			segments.add(new Line(37, 196, 40, 184));
			segments.add(new Line(40, 184, 50, 184));
			segments.add(new Line(50, 184, 52, 174));
			segments.add(new Line(52, 174, 64, 175));
			segments.add(new Line(64, 175, 69, 164));
			segments.add(new Line(69, 164, 81, 165));
			segments.add(new Line(81, 165, 84, 154));
			segments.add(new Line(84, 154, 92, 170));
			segments.add(new Line(92, 170, 87, 173));
			segments.add(new Line(87, 173, 84, 172));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(84, 172,
					71, 177, 49, 195, 41, 215, 67, 211).toBezier()));
			segments.add(new Line(67, 211, 66, 203));
			segments.add(new Line(66, 203, 73, 200));
			segments.add(new Line(73, 200, 81, 205));
			segments.add(new Line(81, 205, 89, 199));
			segments.add(new Line(89, 199, 94, 200));
			segments.add(new Line(94, 200, 94, 209));
			segments.add(new Line(94, 209, 82, 210));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(82, 210,
					80, 219, 78, 228).toBezier()));
			segments.add(new Line(78, 228, 74, 228));
			segments.add(new Line(74, 228, 73, 213));
			segments.add(new Line(73, 213, 52, 226));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(52, 226,
					44, 228, 41, 226).toBezier()));
			segments.add(new Line(41, 226, 27, 197));
			return new CurvedPolygon(segments);
		}

		private IShape createGMiddleShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(64, 190, 65, 198));
			segments.add(new Line(65, 198, 72, 194));
			segments.add(new Line(72, 194, 81, 199));
			segments.add(new Line(81, 199, 89, 193));
			segments.add(new Line(89, 193, 94, 196));
			segments.add(new Line(94, 196, 94, 187));
			segments.add(new Line(94, 187, 89, 186));
			segments.add(new Line(89, 186, 89, 190));
			segments.add(new Line(89, 190, 64, 190));
			return new CurvedPolygon(segments);
		}

		private IShape createGDotShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(90, 224, 87, 228));
			segments.add(new Line(87, 228, 91, 233));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(91, 233,
					95, 229, 90, 224).toBezier()));
			return new CurvedPolygon(segments);
		}

		private IShape createEShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(101, 152, 106, 152));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(106, 152,
					105, 167, 107, 194, 106, 212, 106, 223).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(106, 223,
					105, 225, 103, 226).toBezier()));
			segments.add(new Line(103, 226, 103, 229));
			segments.add(new Line(103, 229, 164, 228));
			segments.add(new Line(164, 228, 165, 221));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(165, 221,
					159, 223, 151, 224).toBezier()));
			segments.add(new Line(151, 224, 112, 224));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(112, 224,
					111, 198, 111, 172).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(111, 172,
					127, 172, 145, 173).toBezier()));
			segments.add(new Line(145, 173, 148, 167));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(148, 167,
					119, 169, 135, 169, 110, 168).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(110, 168,
					110, 162, 111, 152).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(111, 152,
					124, 154, 135, 154, 142, 153, 146, 154, 151, 154)
					.toBezier()));
			segments.add(new Line(151, 154, 155, 148));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(155, 148,
					145, 149, 133, 150, 115, 149, 107, 148).toBezier()));
			segments.add(new Line(107, 148, 101, 152));
			return new CurvedPolygon(segments);
		}

		private IShape createEDotShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(173, 224, 170, 228));
			segments.add(new Line(170, 228, 174, 233));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(174, 233,
					178, 229, 173, 224).toBezier()));
			return new CurvedPolygon(segments);
		}

		private IShape createFShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(178, 155, 178, 165));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(178, 165,
					185, 167, 192, 168).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(192, 168,
					191, 176, 189, 186, 185, 188).toBezier()));
			segments.add(new Line(185, 188, 185, 195));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(185, 195,
					183, 212, 182, 225).toBezier()));
			segments.add(new Line(182, 225, 188, 231));
			segments.add(new Line(188, 231, 192, 227));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(192, 227,
					193, 211, 195, 196).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(195, 196,
					207, 194, 220, 192).toBezier()));
			segments.add(new Line(220, 192, 220, 187));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(220, 187,
					208, 188, 197, 188).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(197, 188,
					198, 176, 200, 168).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(200, 168,
					217, 168, 225, 165, 237, 160, 242, 158).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(242, 158,
					242, 154, 239, 152).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(239, 152,
					229, 156, 217, 158, 203, 158).toBezier()));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(203, 158,
					204, 153, 204, 150, 206, 142).toBezier()));
			segments.add(new Line(206, 142, 199, 145));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(199, 145,
					199, 150, 198, 154).toBezier()));
			segments.add(new Line(198, 154, 195, 153));
			segments.add(new Line(195, 153, 195, 157));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(195, 157,
					188, 157, 178, 155).toBezier()));
			return new CurvedPolygon(segments);
		}

		private IShape createFDotShape() {
			List<BezierCurve> segments = new ArrayList<BezierCurve>();
			segments.add(new Line(228, 224, 225, 228));
			segments.add(new Line(225, 228, 229, 233));
			segments.addAll(Arrays.asList(PolyBezier.interpolateCubic(229, 233,
					233, 229, 228, 224).toBezier()));
			return new CurvedPolygon(segments);
		}

		public IShape[] getShapes() {
			return new IShape[] { s1, s2, createGTopShape(),
					createGBaseShape(), createGMiddleShape(),
					createGDotShape(), createEShape(), createEDotShape(),
					createFShape(), createFDotShape() };
		}

		public ICurve[] getCurves() {
			return new ICurve[] { c1 };
		}

		public IGeometry[] getAllGeometries() {
			List<IGeometry> geometriesList = new ArrayList<>();
			geometriesList.addAll(Arrays.asList(getShapes()));
			geometriesList.addAll(Arrays.asList(getCurves()));
			return geometriesList.toArray(new IGeometry[] {});
		}

		// return anchorages and related anchoreds
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Map<IGeometry, List<IGeometry>> getAnchors() {
			Map<IGeometry, List<IGeometry>> anchors = new HashMap<IGeometry, List<IGeometry>>();
			anchors.put(s1, (List) Collections.singletonList(c1));
			anchors.put(s2, (List) Collections.singletonList(c1));
			return anchors;
		}
	}

	private FXCanvas canvas;

	public FXExampleViewPart() {
	}

	@Override
	public void createPartControl(Composite parent) {
		canvas = new FXCanvas(parent, SWT.NONE);
		FXEditDomain domain = new FXExampleDomain();
		FXViewer viewer = new FXViewer(canvas);
		viewer.setContentPartFactory(new FXExampleContentPartFactory());
		viewer.setHandlePartFactory(new FXExampleHandlePartFactory());
		viewer.setEditDomain(domain);
		viewer.setContents(new ExampleGeometricModel());
	}

	@Override
	public void setFocus() {
		canvas.setFocus();
	}

}
