(ns rosettamesh.j3d
  (:gen-class 
    :name rosettamesh.j3d
    :methods [
    #^{:static true}
    [toIndexedTriangleArray [Object] javax.media.j3d.IndexedTriangleArray]
   #^{:static true}
    [fromIndexedTriangleArray [javax.media.j3d.IndexedTriangleArray] Object]])
  (:use rosettamesh.util))

(import '(javax.media.j3d IndexedTriangleArray))

(defn toIndexedTriangleArray [faceList]
  (let [vertexCount (reduce + (map count faceList))
          vertices (flatten (map #(map float-array %1) faceList))]
    (let [ita (IndexedTriangleArray. 
                vertexCount 
                IndexedTriangleArray/COORDINATES
                vertexCount)]
      (doall (map
          (fn [i v]
            (.setCoordinate ita i v)
            (.setCoordinateIndex ita i i))
        (range vertexCount) vertices))
      ita)))


(defn fromIndexedTriangleArray [obj]
  (partition 3 (let [vertexCount (.getVertexCount obj)]
    (map
      (fn [i]
        (let [buf (float-array '(0 0 0))]
          (.getCoordinates obj i buf)
          (seq buf)))
    (range vertexCount)))))


(defn -toIndexedTriangleArray [o] (toIndexedTriangleArray o))
(defn -fromIndexedTriangleArray [o] (fromIndexedTriangleArray o))

