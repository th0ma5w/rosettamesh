(ns rosettamesh.test.core
  (:use rosettamesh.anar)
  (:use rosettamesh.floatarray)
  (:use rosettamesh.hemesh)
  (:use rosettamesh.igeo)
  (:use rosettamesh.j3d)
  (:use rosettamesh.processing)
  (:use rosettamesh.toxi)
  (:use rosettamesh.unlekker)
  (:use rosettamesh.unwrap)
  (:use [clojure.test]))

(import  
  '(wblut.hemesh.creators HEC_Cone)
  '(processing.core PApplet)
)

(deftest testMeshes
  (let [testMesh (fromHemesh (.create (HEC_Cone. 1 1 20 20)))]
    (let [testResult
      (fromIndexedTriangleArray 
        (toIndexedTriangleArray 
          (fromManyHemesh
            (toManyHemesh
              (fromIgeo
                (toIgeo
                  (fromProcessing
                    (toProcessing
                      (fromAnar
                        (toAnar
                          (fromModelBuilder
                            (toModelBuilder
                              (fromFloatArray
                                (toFloatArray
                                  (fromToxi
                                    (toToxi
                                      (fromHemesh
                                        (toHemesh testMesh))))))))))))))))))] 
    (is testResult "Something broke."))))

(deftest testUnwrap
  (let [testMesh (fromHemesh (.create (HEC_Cone. 1 1 20 20)))]
    (let [testResult 
      (let [p (doto (PApplet.) (.init))] 
        (fromUnwrap (toUnwrap p (.createFont p "Verdana" 48)  testMesh))
      )] (is testResult "Unwrap broke."))))

