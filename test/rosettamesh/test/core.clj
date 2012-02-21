(ns rosettamesh.test.core
  (:use rosettamesh.anar)
  (:use rosettamesh.hemesh)
  (:use rosettamesh.igeo)
  (:use rosettamesh.processing)
  (:use rosettamesh.toxi)
  (:use rosettamesh.unlekker)
  (:use [clojure.test]))

(import  
  '(wblut.hemesh.creators HEC_Cone))

(deftest testAll
  (let [testMesh (fromHemesh (.create (HEC_Cone. 1 1 20 20)))]
    (let [testResult
      (fromIgeo
        (toIgeo
          (fromProcessing
            (toProcessing
              (fromAnar
                (toAnar
                  (fromModelBuilder
                    (toModelBuilder
                      (fromToxi
                        (toToxi
                          (fromHemesh
                            (toHemesh testMesh))))))))))))] 
                              (is testResult "Something broke before here."))))


