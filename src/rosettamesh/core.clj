(ns rosettamesh.core
  (:use rosettamesh.toxi)
  (:use rosettamesh.unlekker)
  (:use rosettamesh.hemesh)
  (:use rosettamesh.util)
)

(import  
  '(toxi.geom Vec3D mesh.TriangleMesh mesh.BezierPatch)
  '(unlekker.modelbuilder UGeometry UVertexList UVec3)
  '(wblut.hemesh.creators HEC_Cube HEC_Cone)
  '(wblut.hemesh.core HE_Mesh HE_Vertex)
  '(wblut.geom.core WB_Point3d)
  '(wblut.hemesh.creators HEC_FromFacelist))

(defn test_toxi []
  (let [ a (new BezierPatch)]
  (.set a 0 0 (Vec3D. 0 0 3))
  (.set a 0 1 (Vec3D. 0 1 2))
  (.set a 1 0 (Vec3D. 1 0 3))
  (.set a 1 1 (Vec3D. 1 1 0))
  (let [ b (.toMesh a 20)]
  (let [ c (fromToxi b)]
  (let [ d (toToxi c)]
  (assert (= (str b) (str d))))))))

(defn test_ModelBuilder []
  (let [a (UVertexList.)]
    (doall (map
      (fn [i]  
        (.add a (* i 400.0) (Math/sin (* (* Math/PI 2) i)) 0)
        (.add a (* i 400.0) (Math/sin (* (* Math/PI 2) i)) 2))
      (range 0 1.01 0.05)))
    (let [b (UGeometry.)]
      (last (doall (list (.triangleFan b a false)
      (toModelBuilder (fromModelBuilder b))))))))


(defn test_hemesh2 []
  (let [aaa (fromHemesh (.create (HEC_Cone. 1 1 20 20)))]
    (toHemesh aaa)
  )
)

;(.saveAsSTL (toToxi (fromModelBuilder (toModelBuilder (fromHemesh (test_hemesh2))))) "three1.stl")

