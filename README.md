# rosettamesh!

A collection of triangle mesh conversions for Processing, Clojure, and Java.

## Supported Libraries

- [anar+] (http://anar.ch/)
- [FluidFormsLibs] (http://fluidforms.eu/processing/fluid-forms-libs/)
- [He_Mesh] (http://hemesh.wblut.com/)
- [Java 3d] (http://java3d.java.net/)
- [ModelBuilder] (https://github.com/mariuswatz/modelbuilder)
- [piGeon] (http://igeo.jp/p/)
- [Processing PVectors in ArrayLists] (http://processing.org)
- [toxiclibs] (http://toxiclibs.org/)
- [UnwrappingLib] (http://www.undef.ch/unwrappinglib)

## TODO

- Better api namespace
- Subfeatures of libraries such as triangulation of non-triangle meshes
- More tests and examples

## Methods

An intermediary java.lang.Object (a Clojure list of lists of coordinates) is
created or consumed by mix-in static methods. You will probably want to
use a mix of two of each of these, making sure your input and output
types match your intentions, that is, to take the source, create the
unused intermediary format, and then use that to create the target.

- Only triangle meshes, if possible, and from / to faces
- Can be chained (see tests)
- Some may be broken (anar, igeo?)
- If a mesh is not valid in the target or source, there may be errors
- Some loss of precision may occur (floats and doubles) 
- Some libraries also require Processing's core.jar
- If you don't use the library's functions, Java shouldn't need their jars
- May be slow with larger meshes
- No support for color (there are a lot of opinions out there!)
- Might screw up normals, might not

## Usage

### Processing & Java Methods

    (anar.Obj) anar.toAnar(Object)
    (Object) anar.fromAnar(anar.Obj)

    (eu.fluidforms.geom.FSolid) fluidforms.toFSolid(Object)
    (Object) fluidforms.fromFSolid(eu.fluidforms.geom.FSolid)

    (float[][][]) floatarray.toFloatArray(Object)
    (Object) floatarray.fromFloatArray(float[][][])

    (wblut.hemesh.core.HE_Mesh) hemesh.toHemesh(Object)
    (Object) hemesh.fromHemesh(wblut.hemesh.core.HE_Mesh)

    (igeo.IMeshGeo) igeo.toIgeo(Object)
    (Object) igeo.fromIgeo(igeo.IMeshGeo)

    (javax.media.j3d.IndexedTriangleArray) j3d.toIndexedTriangleArray (Object)
    (Object) j3d.fromIndexedTriangleArray (javax.media.j3d.IndexedTriangleArray)

    (java.util.ArrayList) processing.toProcessing(Object)
    (Object) processing.fromProcessing(java.util.ArrayList)

    (toxi.geom.mesh.TriangleMesh) toxi.toToxi(Object)
    (Object) toxi.fromToxi(toxi.geom.mesh.TriangleMesh)

    (unlekker.modelbuilder.UGeometry) unlekker.toModelBuilder(Object)
    (Object) unlekker.fromModelBuilder(unlekker.modelbuilder.UGeometry)

    (unwrap.Unwrap) unwrap.toUnwrap(processing.core.PApplet processing.core.PFont Object)
    (Object) unwrap.fromUnwrap(unwrap.Unwrap)

#### Example

    import rosettamesh.*;
    toxi.toToxi(hemesh.fromHemesh((new HEC_Cone(1,1,20,20)).create())).saveAsSTL("test.stl");
    

### Clojure

Browse the code, and copy in what you need. Put the source libraries
into your project's lib/ folder or install each manually via Maven2, and
list the libraries as project dependencies. Without explicit dependencies
the lib/ folder will be cleared when executing lein clean.

#### Example

    (toModelBuilder 
      (fromToxi (toToxi 
        (fromHemesh (.create (HEC_Cone. 1 1 20 20))))))

#### To build a jar for Processing and Java:

    1. copy the source libraries into lib/
    2. if not using all, edit src/rosettamesh/core.clj and remove unused libs
    3. lein jar  .... (or lein uberjar)

## License

Copyright (C) 2012 Declarie Limited

Distributed under the Eclipse Public License, the same as Clojure.

find me at [twitter.com/th0ma5] (http://twitter.com/th0ma5)

