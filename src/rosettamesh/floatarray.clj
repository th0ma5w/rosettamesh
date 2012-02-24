(ns rosettamesh.floatarray
  (:gen-class 
    :name rosettamesh.floatarray
    :methods [#^{:static true}[toFloatArray [Object] "[[[F" ]
                     #^{:static true}[fromFloatArray ["[[[F"] Object]])
)

(defn toFloatArray [o]
  (into-array (map #(into-array (map float-array %1)) o)))

(defn fromFloatArray [farray]
  (map (fn [a] (map (fn [b] (map (fn [c] c )b)) a)) farray))

(defn -toFloatArray [o] (toFloatArray o))
(defn -fromFloatArray [o] (fromFloatArray o))

