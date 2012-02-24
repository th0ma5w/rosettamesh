# rosettamesh!

A collection of triangle mesh conversions for Processing, Clojure, and Java.

## Supported Libraries

- [anar+] (http://anar.ch/)
- [He_Mesh] (http://hemesh.wblut.com/)
- [ModelBuilder] (http://code.google.com/p/codeandform/)
- [piGeon] (http://igeo.jp/p/)
- [Processing PVectors in ArrayLists] (http://processing.org)
- [toxiclibs] (http://toxiclibs.org/)
- [UnwrappingLib] (http://www.undef.ch/unwrappinglib)

## TODO

- [Geomerative] (http://www.ricardmarxer.com/geomerative/)
- Triangle Strips to Triangles and back
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
- Some loss of precision may occur (floats and doubles) 
- Some libraries also require Processing's core.jar
- If you don't use the library's functions, Java shouldn't need their jars
- May be slow with larger meshes

## Usage

### Processing & Java Methods

    (anar.Obj) anar.toAnar(java.lang.Object)
    (java.lang.Object) anar.fromAnar(anar.Obj)

    (float[][][]) floatarray.toFloatArray(java.lang.Object)
    (java.lang.Object) floatarray.fromFloatArray(float[][][])

    (wblut.hemesh.core.HE_Mesh) hemesh.toHemesh(java.lang.Object)
    (java.lang.Object) hemesh.fromHemesh(wblut.hemesh.core.HE_Mesh)
    (wblut.hemesh.core.HE_Mesh[]) hemesh.toManyHemesh(java.lang.Object)
    (java.lang.Object) hemesh.fromManyHemesh(wblut.hemesh.core.HE_Mesh[])

    (igeo.IMeshGeo) igeo.toIgeo(java.lang.Object)
    (java.lang.Object) igeo.fromIgeo(igeo.IMeshGeo)

    (java.util.ArrayList) processing.toProcessing(java.lang.Object)
    (java.lang.Object) processing.fromProcessing(java.util.ArrayList)

    (toxi.geom.mesh.TriangleMesh) toxi.toToxi(java.lang.Object)
    (java.lang.Object) toxi.fromToxi(toxi.geom.mesh.TriangleMesh)

    (unlekker.modelbuilder.UGeometry) unlekker.toModelBuilder(java.lang.Object)
    (java.lang.Object) unlekker.fromModelBuilder(unlekker.modelbuilder.UGeometry)

    (unwrap.Unwrap) unwrap.toUnwrap(processing.core.PApplet processing.core.PFont Object)
    (java.lang.Object) unwrap.fromUnwrap(unwrap.Unwrap)

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

