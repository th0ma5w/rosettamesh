(ns rosettamesh.test.core
  (:use rosettamesh.toxi)
  (:use rosettamesh.unlekker)
  (:use rosettamesh.hemesh)
  (:use rosettamesh.anar)
  (:use rosettamesh.processing)
  (:use [clojure.test]))

(import  
  '(wblut.hemesh.creators HEC_Cone))

(deftest testAll
  (let [testMesh (fromHemesh (.create (HEC_Cone. 1 1 20 20)))]
    (let [testResult
      (fromProcessing
        (toProcessing
          (fromAnar
            (toAnar
              (fromModelBuilder
                (toModelBuilder
                  (fromToxi
                    (toToxi
                      (fromHemesh
                        (toHemesh testMesh))))))))))] 
                          (is testResult "Something broke before here."))))


