(ns rosettamesh.hemesh
  (:gen-class 
    :name rosettamesh.hemesh
    :methods [#^{:static true}[toHemesh [Object] wblut.hemesh.core.HE_Mesh]
                     #^{:static true}[fromHemesh [wblut.hemesh.core.HE_Mesh] Object]])
  (:use rosettamesh.util))

(import  '(wblut.geom.core WB_Point3d WB_ExplicitTriangle)
'(wblut.hemesh.creators HEC_FromTriangles))

(defn toHemesh [faceList]
  (.create (doto (HEC_FromTriangles.) 
    (.setTriangles (into-array 
    (map (fn [[a b c]] (WB_ExplicitTriangle. a b c))
      (map (fn [face]
          (map (fn [[x y z]]
              (WB_Point3d. x y z))
                face))
                  faceList)))))))

(defn fromHemesh [hemesh]
  (last (doall (list
    (.triangulate hemesh) 
    (map (fn [a] 
      (reverse (map (fn [b] (callList b x y z)) 
        (.getFaceVertices a) )) )
          (.getFacesAsArray hemesh))))))

(defn -toHemesh [o] (toHemesh o))
(defn -fromHemesh [o] (fromHemesh o))

