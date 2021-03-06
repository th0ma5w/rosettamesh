(ns rosettamesh.toxi
  (:gen-class 
    :name rosettamesh.toxi
    :methods [#^{:static true}[toToxi [Object] toxi.geom.mesh.TriangleMesh]
                     #^{:static true}[fromToxi [toxi.geom.mesh.TriangleMesh] Object]])
  (:use rosettamesh.util))

(import  '(toxi.geom Vec3D mesh.TriangleMesh))

(defn toToxi [faceList]
  (let [mesh (TriangleMesh.)
          v3d  (fn [[x y z]] (Vec3D. x y z))]
    (last (map (fn [[a b c]]
      (.addFace mesh (v3d a) (v3d b) (v3d c)))
    faceList))))

(defn fromToxi [toximesh] 
  (map (fn [face]
      (map (fn [vertex]
          (callList vertex x y z))
        (callList face a b c)))
  (.faces toximesh)))

(defn -toToxi [o] (toToxi o))
(defn -fromToxi [o] (fromToxi o))

