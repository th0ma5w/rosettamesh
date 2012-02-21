(ns rosettamesh.igeo
  (:gen-class 
    :name rosettamesh.igeo
    :methods [#^{:static true}[toIgeo [Object] igeo.IMeshGeo]
                     #^{:static true}[fromIgeo [igeo.IMeshGeo] Object]])
  (:use rosettamesh.util))

(import '(igeo IMesh IFace IVertex))

(defn toIgeo [faceList]
  (.get (IMesh. (into-array (map
    (fn [face] 
      ((fn [[a b c]] (IFace. a b c) ) 
        (map
          (fn [[x y z]] (IVertex. x y z))
            face)))
              faceList)))))

(defn fromIgeo [ig]
  (map
    (fn [face]
      (map
        (fn [vertex] (callList vertex x y z))
          (.vertices face)))
            (.faces ig)))

(defn -toIgeo [o] (toIgeo o))
(defn -fromIgeo [o] (fromIgeo o))


