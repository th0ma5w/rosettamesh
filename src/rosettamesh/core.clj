(ns rosettamesh.core
  (:gen-class)
  (:use rosettamesh.toxi)
  (:use rosettamesh.unlekker)
  (:use rosettamesh.hemesh)
  (:use rosettamesh.anar)
  (:use rosettamesh.processing)
)

(import  
  '(wblut.hemesh.creators HEC_Cone))

(defn -main [& args]
  (let [testMesh (fromHemesh (.create (HEC_Cone. 1 1 20 20)))]
    (let [testAll
    (fromProcessing
      (toProcessing
        (fromAnar
          (toAnar
            (fromModelBuilder
              (toModelBuilder
                (fromToxi
                  (toToxi
                    (fromHemesh
                      (toHemesh testMesh)
)))))))))
])))

