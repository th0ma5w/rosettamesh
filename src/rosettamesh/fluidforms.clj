(ns rosettamesh.fluidforms
  (:gen-class 
    :name rosettamesh.fluidforms
    :methods [#^{:static true}[toFSolid [Object] eu.fluidforms.geom.FSolid]
                     #^{:static true}[fromFSolid [eu.fluidforms.geom.FSolid] Object]])
  (:use rosettamesh.util)
)

(import '(eu.fluidforms.geom FSolid FTriangle FVertex))

(defn toFSolid [faceList]
  (let [fsolid (FSolid.)]
    (.addTriangles fsolid 
      (java.util.ArrayList. (map (fn [face]
        ((fn [[a b c]] (FTriangle. a b c) ) (map (fn [[x y z]] 
          (FVertex. (float x) (float y) (float z))) 
            face))) faceList))) fsolid))

(defn fromFSolid [fsolid]
  (map (fn [face]
    (map (fn [vertex]
      (callList vertex x y z))
        (callList face v1 v2 v3)))
          (.getTriangles fsolid)))

(defn -toFSolid [o] (toFSolid o))
(defn -fromFSolid [o] (fromFSolid o))

