/*
 * one.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Dec 3 2019, 14:42 by COMSOL 5.5.0.292. */
public class one {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("D:\\");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("solid", "SolidMechanics", "geom1");

    model.study().create("std1");
    model.study("std1").create("stat", "Stationary");
    model.study("std1").feature("stat").activate("solid", true);

    model.param().label("A");
    model.param().set("a", "10");

    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat1").propertyGroup().create("linzRes", "Linearized resistivity");
    model.component("comp1").material("mat1").label("Copper");
    model.component("comp1").material("mat1").set("family", "copper");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("relpermeability_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("electricconductivity", new String[]{"5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("electricconductivity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"17e-6[1/K]", "0", "0", "0", "17e-6[1/K]", "0", "0", "0", "17e-6[1/K]"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("thermalexpansioncoefficient_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("heatcapacity", "385[J/(kg*K)]");
    model.component("comp1").material("mat1").propertyGroup("def").descr("heatcapacity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("relpermittivity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("density", "8960[kg/m^3]");
    model.component("comp1").material("mat1").propertyGroup("def").descr("density_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalconductivity", new String[]{"400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("thermalconductivity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("youngsmodulus", "110e9[Pa]");
    model.component("comp1").material("mat1").propertyGroup("Enu").descr("youngsmodulus_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("poissonsratio", "0.35");
    model.component("comp1").material("mat1").propertyGroup("Enu").descr("poissonsratio_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "1.72e-8[ohm*m]");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "0.0039[1/K]");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "298[K]");
    model.component("comp1").material("mat1").propertyGroup("linzRes").descr("rho0_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").descr("alpha_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").descr("Tref_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").addInput("temperature");
    model.component("comp1").material("mat1").set("groups", new String[][]{});
    model.component("comp1").material("mat1").set("family", "copper");

    model.component("comp1").geom("geom1").create("blk1", "Block");

    model.param().set("b", "2");
    model.param().set("c", "10");

    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"a", "b", "c"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk1").set("axistype", "z");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").physics("solid").create("fix1", "Fixed", 2);
    model.component("comp1").physics("solid").feature("fix1").selection().set(2);
    model.component("comp1").physics("solid").create("bndl1", "BoundaryLoad", 2);
    model.component("comp1").physics("solid").feature("bndl1").selection().set(2, 5);
    model.component("comp1").physics("solid").feature("bndl1").set("FperArea", new int[]{0, 0, -500});

    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(1);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(9);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").create("size1", "Size");
    model.component("comp1").mesh("mesh1").feature().remove("size1");
    model.component("comp1").mesh("mesh1").feature("size").set("hmax", 0.4);
    model.component("comp1").mesh("mesh1").feature("size").set("hmin", 0.2);
    model.component("comp1").mesh("mesh1").feature("size").set("hgrad", 1.3);
    model.component("comp1").mesh("mesh1").feature("size").set("hcurve", 0.2);
    model.component("comp1").mesh("mesh1").feature("size").set("hnarrow", 1);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").feature("size").set("hmax", 5);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").feature("size").set("custom", true);
    model.component("comp1").mesh("mesh1").feature("size").set("hmin", 1);
    model.component("comp1").mesh("mesh1").run("size");

    model.component("comp1").geom("geom1").run("fin");

    model.component("comp1").mesh("mesh1").feature("size").set("custom", false);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").feature("size").set("hauto", 2);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").feature("size").set("custom", false);
    model.component("comp1").mesh("mesh1").feature("size").set("hauto", 1);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").run("size");
    model.component("comp1").mesh("mesh1").feature("size").set("hmax", 0.4);
    model.component("comp1").mesh("mesh1").feature("size").set("hmin", 0.2);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").create("ftet1", "FreeTet");
    model.component("comp1").mesh("mesh1").run();

    model.sol().create("sol1");
    model.sol("sol1").study("std1");

    model.study("std1").feature("stat").set("notlistsolnum", 1);
    model.study("std1").feature("stat").set("notsolnum", "1");
    model.study("std1").feature("stat").set("listsolnum", 1);
    model.study("std1").feature("stat").set("solnum", "1");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").feature("aDef").set("cachepattern", true);
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("termonres", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("reserrfact", 1000);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "mumps");
    model.sol("sol1").feature("s1").feature("d1").label("Suggested Direct Solver (solid)");
    model.sol("sol1").feature("s1").create("i1", "Iterative");
    model.sol("sol1").feature("s1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("s1").feature("i1").set("rhob", 400);
    model.sol("sol1").feature("s1").feature("i1").set("nlinnormuse", true);
    model.sol("sol1").feature("s1").feature("i1").label("Suggested Iterative Solver (solid)");
    model.sol("sol1").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").set("prefun", "gmg");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").feature("so1").set("relax", 0.8);
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").feature("so1").set("relax", 0.8);
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("termonres", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("reserrfact", 1000);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").set("data", "dset1");
    model.result("pg1").create("surf1", "Surface");
    model.result("pg1").feature("surf1").set("expr", new String[]{"solid.mises"});
    model.result("pg1").label("Stress (solid)");
    model.result("pg1").feature("surf1").set("colortable", "RainbowLight");
    model.result("pg1").feature("surf1").set("resolution", "normal");
    model.result("pg1").feature("surf1").create("def", "Deform");
    model.result("pg1").feature("surf1").feature("def").set("expr", new String[]{"u", "v", "w"});
    model.result("pg1").feature("surf1").feature("def").set("descr", "Displacement field");

    model.nodeGroup().create("dset1solidlgrp", "Results");
    model.nodeGroup("dset1solidlgrp").label("Applied Loads (solid)");
    model.nodeGroup("dset1solidlgrp").set("type", "plotgroup");
    model.nodeGroup("dset1solidlgrp").placeAfter("plotgroup", "pg1");

    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").set("data", "dset1");
    model.result("pg2").label("Boundary Loads (solid)");

    model.nodeGroup("dset1solidlgrp").add("plotgroup", "pg2");

    model.result("pg2").set("showlegends", true);
    model.result("pg2").set("titletype", "custom");
    model.result("pg2").set("typeintitle", false);
    model.result("pg2").set("descriptionintitle", false);
    model.result("pg2").set("unitintitle", false);
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsunit", true);
    model.result("pg2").create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("expr", new String[]{"1"});
    model.result("pg2").feature("surf1").label("Gray Surfaces");
    model.result("pg2").feature("surf1").set("coloring", "uniform");
    model.result("pg2").feature("surf1").set("color", "gray");
    model.result("pg2").feature("surf1").active(false);
    model.result("pg2").feature("surf1").create("def", "Deform");
    model.result("pg2").feature("surf1").feature("def").set("expr", new String[]{"u", "v", "w"});
    model.result("pg2").feature("surf1").feature("def").set("descr", "Displacement field");
    model.result("pg2").feature("surf1").feature("def").set("scaleactive", true);
    model.result("pg2").feature("surf1").feature("def").set("scale", 0);
    model.result("pg2").create("arws1", "ArrowSurface");
    model.result("pg2").feature("arws1")
         .set("expr", new String[]{"solid.bndl1.F_Ax", "solid.bndl1.F_Ay", "solid.bndl1.F_Az"});
    model.result("pg2").feature("arws1").set("placement", "gausspoints");
    model.result("pg2").feature("arws1").set("arrowbase", "tail");
    model.result("pg2").feature("arws1").label("Boundary Load 1");
    model.result("pg2").feature().move("surf1", 1);
    model.result("pg2").feature("arws1").set("inheritplot", "none");
    model.result("pg2").feature("arws1").create("col", "Color");
    model.result("pg2").feature("arws1").feature("col").set("expr", "comp1.solid.bndl1.F_A_Mag");
    model.result("pg2").feature("arws1").feature("col").set("colortable", "Spectrum");
    model.result("pg2").feature("arws1").feature("col").set("coloring", "gradient");
    model.result("pg2").feature("arws1").feature("col").set("topcolor", "red");
    model.result("pg2").feature("arws1").set("color", "red");
    model.result("pg2").feature("arws1").create("def", "Deform");
    model.result("pg2").feature("arws1").feature("def").set("expr", new String[]{"u", "v", "w"});
    model.result("pg2").feature("arws1").feature("def").set("descr", "Displacement field");
    model.result("pg2").feature("arws1").feature("def").set("scaleactive", true);
    model.result("pg2").feature("arws1").feature("def").set("scale", 0);

    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result().export().create("anim1", "Animation");
    model.result().export("anim1").set("target", "player");
    model.result().export("anim1").set("fontsize", "9");
    model.result().export("anim1").set("customcolor", new double[]{1, 1, 1});
    model.result().export("anim1").set("background", "color");
    model.result().export("anim1").set("gltfincludelines", "on");
    model.result().export("anim1").set("title1d", "on");
    model.result().export("anim1").set("legend1d", "on");
    model.result().export("anim1").set("logo1d", "on");
    model.result().export("anim1").set("options1d", "on");
    model.result().export("anim1").set("title2d", "on");
    model.result().export("anim1").set("legend2d", "on");
    model.result().export("anim1").set("logo2d", "on");
    model.result().export("anim1").set("options2d", "off");
    model.result().export("anim1").set("title3d", "on");
    model.result().export("anim1").set("legend3d", "on");
    model.result().export("anim1").set("logo3d", "on");
    model.result().export("anim1").set("options3d", "off");
    model.result().export("anim1").set("axisorientation", "on");
    model.result().export("anim1").set("grid", "on");
    model.result().export("anim1").set("axes1d", "on");
    model.result().export("anim1").set("axes2d", "on");
    model.result().export("anim1").set("showgrid", "on");
    model.result().export("anim1").set("sweeptype", "dde");
    model.result().export("anim1").set("showframe", 25);
    model.result().export("anim1").run();
    model.result().export("anim1").set("repeat", true);
    model.result().export("anim1").set("stopped", true);
    model.result().export("anim1").run();
    model.result().report().create("rpt1", "Report");
    model.result().report("rpt1").set("templatesource", "complete");
    model.result().report("rpt1").feature().clear();
    model.result().report("rpt1").create("tp1", "TitlePage");
    model.result().report("rpt1").create("toc1", "TableOfContents");
    model.result().report("rpt1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec1").set("heading", "Global Definitions");
    model.result().report("rpt1").feature("sec1").create("root1", "Model");
    model.result().report("rpt1").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec1").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec1").feature("sec1").set("heading", "Parameters");
    model.result().report("rpt1").feature("sec1").feature("sec1").create("param1", "Parameter");
    model.result().report("rpt1").feature("sec1").feature("sec1").feature("param1").set("noderef", "default");
    model.result().report("rpt1").create("sec2", "Section");
    model.result().report("rpt1").feature("sec2").set("source", "custom");
    model.result().report("rpt1").feature("sec2").set("heading", "Component 1");
    model.result().report("rpt1").feature("sec2").create("comp1", "ModelNode");
    model.result().report("rpt1").feature("sec2").feature("comp1").set("noderef", "comp1");
    model.result().report("rpt1").feature("sec2").feature("comp1").set("includeauthor", true);
    model.result().report("rpt1").feature("sec2").feature("comp1").set("includedatecreated", true);
    model.result().report("rpt1").feature("sec2").feature("comp1").set("includeversion", true);
    model.result().report("rpt1").feature("sec2").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec2").feature("sec1").set("heading", "Definitions");
    model.result().report("rpt1").feature("sec2").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1")
         .set("heading", "Coordinate Systems");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1")
         .set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1")
         .set("heading", "Boundary System 1");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1")
         .create("csys1", "CoordinateSystem");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1").feature("csys1")
         .set("noderef", "sys1");
    model.result().report("rpt1").feature("sec2").create("sec2", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec2").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec2").set("heading", "Geometry 1");
    model.result().report("rpt1").feature("sec2").feature("sec2").create("geom1", "Geometry");
    model.result().report("rpt1").feature("sec2").feature("sec2").feature("geom1").set("noderef", "geom1");
    model.result().report("rpt1").feature("sec2").create("sec3", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec3").set("source", "custom");
    model.result().report("rpt1").feature("sec2").feature("sec3").set("heading", "Materials");
    model.result().report("rpt1").feature("sec2").feature("sec3").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").set("heading", "Copper");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").create("mat1", "Material");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").feature("mat1")
         .set("noderef", "mat1");
    model.result().report("rpt1").feature("sec2").create("sec4", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec4").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec4").set("heading", "Solid Mechanics");
    model.result().report("rpt1").feature("sec2").feature("sec4").create("phys1", "Physics");
    model.result().report("rpt1").feature("sec2").feature("sec4").feature("phys1").set("noderef", "solid");
    model.result().report("rpt1").feature("sec2").create("sec5", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec5").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec5").set("heading", "Mesh 1");
    model.result().report("rpt1").feature("sec2").feature("sec5").create("mesh1", "Mesh");
    model.result().report("rpt1").feature("sec2").feature("sec5").feature("mesh1").set("noderef", "mesh1");
    model.result().report("rpt1").create("sec3", "Section");
    model.result().report("rpt1").feature("sec3").set("source", "custom");
    model.result().report("rpt1").feature("sec3").set("heading", "Study 1");
    model.result().report("rpt1").feature("sec3").create("std1", "Study");
    model.result().report("rpt1").feature("sec3").feature("std1").set("noderef", "std1");
    model.result().report("rpt1").feature("sec3").create("sec1", "Section");
    model.result().report("rpt1").feature("sec3").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec3").feature("sec1").set("heading", "Solver Configurations");
    model.result().report("rpt1").feature("sec3").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").set("heading", "Solution 1");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").create("sol1", "Solver");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").feature("sol1")
         .set("noderef", "sol1");
    model.result().report("rpt1").create("sec4", "Section");
    model.result().report("rpt1").feature("sec4").set("source", "custom");
    model.result().report("rpt1").feature("sec4").set("heading", "Results");
    model.result().report("rpt1").feature("sec4").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec4").feature("sec1").set("heading", "Datasets");
    model.result().report("rpt1").feature("sec4").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1")
         .set("heading", "Study 1/Solution 1");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1").create("dset1", "DataSet");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1").feature("dset1")
         .set("noderef", "dset1");
    model.result().report("rpt1").feature("sec4").create("sec2", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec2").set("source", "custom");
    model.result().report("rpt1").feature("sec4").feature("sec2").set("heading", "Plot Groups");
    model.result().report("rpt1").feature("sec4").feature("sec2").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").set("heading", "Stress (solid)");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").create("pg1", "PlotGroup");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").feature("pg1")
         .set("noderef", "pg1");
    model.result().report("rpt1").feature("sec4").create("sec3", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec3").set("source", "custom");
    model.result().report("rpt1").feature("sec4").feature("sec3").set("heading", "Applied Loads (solid)");
    model.result().report("rpt1").feature("sec4").feature("sec3").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1")
         .set("heading", "Boundary Loads (solid)");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1").create("pg1", "PlotGroup");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1").feature("pg1")
         .set("noderef", "pg2");
    model.result().report("rpt1").set("imagegeneration", "suppress");
    model.result().report("rpt1").set("format", "docx");
    model.result().report("rpt1").set("filename", "D:\\Report.docx");
    model.result().report("rpt1").set("imagegeneration", true);
    model.result().report("rpt1").feature().clear();
    model.result().report("rpt1").create("tp1", "TitlePage");
    model.result().report("rpt1").create("toc1", "TableOfContents");
    model.result().report("rpt1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec1").set("heading", "Global Definitions");
    model.result().report("rpt1").feature("sec1").create("root1", "Model");
    model.result().report("rpt1").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec1").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec1").feature("sec1").set("heading", "Parameters");
    model.result().report("rpt1").feature("sec1").feature("sec1").create("param1", "Parameter");
    model.result().report("rpt1").feature("sec1").feature("sec1").feature("param1").set("noderef", "default");
    model.result().report("rpt1").create("sec2", "Section");
    model.result().report("rpt1").feature("sec2").set("source", "custom");
    model.result().report("rpt1").feature("sec2").set("heading", "Component 1");
    model.result().report("rpt1").feature("sec2").create("comp1", "ModelNode");
    model.result().report("rpt1").feature("sec2").feature("comp1").set("noderef", "comp1");
    model.result().report("rpt1").feature("sec2").feature("comp1").set("includeauthor", true);
    model.result().report("rpt1").feature("sec2").feature("comp1").set("includedatecreated", true);
    model.result().report("rpt1").feature("sec2").feature("comp1").set("includeversion", true);
    model.result().report("rpt1").feature("sec2").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec2").feature("sec1").set("heading", "Definitions");
    model.result().report("rpt1").feature("sec2").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1")
         .set("heading", "Coordinate Systems");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1")
         .set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1")
         .set("heading", "Boundary System 1");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1")
         .create("csys1", "CoordinateSystem");
    model.result().report("rpt1").feature("sec2").feature("sec1").feature("sec1").feature("sec1").feature("csys1")
         .set("noderef", "sys1");
    model.result().report("rpt1").feature("sec2").create("sec2", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec2").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec2").set("heading", "Geometry 1");
    model.result().report("rpt1").feature("sec2").feature("sec2").create("geom1", "Geometry");
    model.result().report("rpt1").feature("sec2").feature("sec2").feature("geom1").set("noderef", "geom1");
    model.result().report("rpt1").feature("sec2").create("sec3", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec3").set("source", "custom");
    model.result().report("rpt1").feature("sec2").feature("sec3").set("heading", "Materials");
    model.result().report("rpt1").feature("sec2").feature("sec3").create("sec1", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").set("heading", "Copper");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").create("mat1", "Material");
    model.result().report("rpt1").feature("sec2").feature("sec3").feature("sec1").feature("mat1")
         .set("noderef", "mat1");
    model.result().report("rpt1").feature("sec2").create("sec4", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec4").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec4").set("heading", "Solid Mechanics");
    model.result().report("rpt1").feature("sec2").feature("sec4").create("phys1", "Physics");
    model.result().report("rpt1").feature("sec2").feature("sec4").feature("phys1").set("noderef", "solid");
    model.result().report("rpt1").feature("sec2").create("sec5", "Section");
    model.result().report("rpt1").feature("sec2").feature("sec5").set("source", "firstchild");
    model.result().report("rpt1").feature("sec2").feature("sec5").set("heading", "Mesh 1");
    model.result().report("rpt1").feature("sec2").feature("sec5").create("mesh1", "Mesh");
    model.result().report("rpt1").feature("sec2").feature("sec5").feature("mesh1").set("noderef", "mesh1");
    model.result().report("rpt1").create("sec3", "Section");
    model.result().report("rpt1").feature("sec3").set("source", "custom");
    model.result().report("rpt1").feature("sec3").set("heading", "Study 1");
    model.result().report("rpt1").feature("sec3").create("std1", "Study");
    model.result().report("rpt1").feature("sec3").feature("std1").set("noderef", "std1");
    model.result().report("rpt1").feature("sec3").create("sec1", "Section");
    model.result().report("rpt1").feature("sec3").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec3").feature("sec1").set("heading", "Solver Configurations");
    model.result().report("rpt1").feature("sec3").feature("sec1").create("sec1", "Section");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").set("heading", "Solution 1");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").create("sol1", "Solver");
    model.result().report("rpt1").feature("sec3").feature("sec1").feature("sec1").feature("sol1")
         .set("noderef", "sol1");
    model.result().report("rpt1").create("sec4", "Section");
    model.result().report("rpt1").feature("sec4").set("source", "custom");
    model.result().report("rpt1").feature("sec4").set("heading", "Results");
    model.result().report("rpt1").feature("sec4").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec1").set("source", "custom");
    model.result().report("rpt1").feature("sec4").feature("sec1").set("heading", "Datasets");
    model.result().report("rpt1").feature("sec4").feature("sec1").create("sec1", "Section");

    return model;
  }

  public static Model run2(Model model) {
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1")
         .set("heading", "Study 1/Solution 1");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1").create("dset1", "DataSet");
    model.result().report("rpt1").feature("sec4").feature("sec1").feature("sec1").feature("dset1")
         .set("noderef", "dset1");
    model.result().report("rpt1").feature("sec4").create("sec2", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec2").set("source", "custom");
    model.result().report("rpt1").feature("sec4").feature("sec2").set("heading", "Plot Groups");
    model.result().report("rpt1").feature("sec4").feature("sec2").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").set("heading", "Stress (solid)");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").create("pg1", "PlotGroup");
    model.result().report("rpt1").feature("sec4").feature("sec2").feature("sec1").feature("pg1")
         .set("noderef", "pg1");
    model.result().report("rpt1").feature("sec4").create("sec3", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec3").set("source", "custom");
    model.result().report("rpt1").feature("sec4").feature("sec3").set("heading", "Applied Loads (solid)");
    model.result().report("rpt1").feature("sec4").feature("sec3").create("sec1", "Section");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1").set("source", "firstchild");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1")
         .set("heading", "Boundary Loads (solid)");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1").create("pg1", "PlotGroup");
    model.result().report("rpt1").feature("sec4").feature("sec3").feature("sec1").feature("pg1")
         .set("noderef", "pg2");
    model.result().report("rpt1").feature("tp1").set("title", "Ashok");
    model.result().report("rpt1").feature("tp1").set("company", "RAJALAKSHMI INSTITUTE OF TECHNOLOGY");
    model.result().report("rpt1").feature("tp1").set("version", "V1");
    model.result().report("rpt1").feature("tp1").run();
    model.result().report("rpt1").run();

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    run2(model);
  }

}
