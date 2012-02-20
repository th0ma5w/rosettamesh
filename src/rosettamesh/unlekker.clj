(ns rosettamesh.unlekker
  (:use rosettamesh.util))

(import '(unlekker.modelbuilder UGeometry UVec3)
  '(processing.core PApplet))

(defn toModelBuilder [faceList]
  (let [ugeom (UGeometry.)
          uv3  (fn [[x y z]] (UVec3. x y z))]
    (.beginShape ugeom PApplet/TRIANGLES)
    (doall (map (fn [[c b a]]
      (.addFace ugeom (uv3 a) (uv3 b) (uv3 c)))
    faceList))
    (.endShape ugeom)
    ugeom) )

(defn fromModelBuilder [ugeom] 
  (map (fn [face]
      (map (fn [vertex]
          (callList vertex x y z))
        (.v face)))
  (cleanNil (.face ugeom))))


