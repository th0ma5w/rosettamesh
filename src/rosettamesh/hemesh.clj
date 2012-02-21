(ns rosettamesh.hemesh
  (:gen-class 
    :name rosettamesh.hemesh
    :methods [#^{:static true}[toHemesh [Object] Object]
                     #^{:static true}[fromHemesh [Object] Object]])
  (:use rosettamesh.util))

(import  '(wblut.geom.core WB_Point3d WB_ExplicitTriangle)
'(wblut.hemesh.creators HEC_FromTriangles))

(defn fromHemesh [hemesh]
  (last (doall (list
    (.triangulate hemesh) 
    (map (fn [a] 
      (reverse (map (fn [b] (callList b x y z)) 
        (.getFaceVertices a) )) )
          (.getFacesAsArray hemesh))))))

(defn toHemesh [faceList]
  (.create (doto (HEC_FromTriangles.) 
    (.setTriangles (into-array 
    (map (fn [[a b c]] (WB_ExplicitTriangle. a b c))
      (map (fn [face]
          (map (fn [[x y z]]
              (WB_Point3d. x y z))
                face))
                  faceList)))))))

(defn -fromHemesh [o] (fromHemesh o))
(defn -toHemesh [o] (toHemesh o))

