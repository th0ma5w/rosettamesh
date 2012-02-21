(ns rosettamesh.unwrap
  (:gen-class 
    :name rosettamesh.unwrap
    :methods [#^{:static true}[toUnwrap [processing.core.PApplet processing.core.PFont Object] unwrap.Unwrap]
                     #^{:static true}[fromUnwrap [unwrap.Unwrap] Object]])
  (:use rosettamesh.util))

(import '(unwrap Unwrap UPoint UTriangle)
  '(processing.core PApplet))

(defn toUnwrap [theParent font faceList]
  (let [
  utri 
      (fn [[a b c] trinum] (UTriangle. a b c trinum)) 
  pointMap 
      (map (fn [face facenum] 
        (map (fn [[x y z] trinum]
              (UPoint. x y z  (+ (* facenum 3) trinum)) )
          face (range (count face)) )) 
            faceList (range (count faceList)))
  ]
  (let [
    triMap (map utri pointMap (range (count pointMap)))
    u (Unwrap. theParent font)
    ]
    (do 
        (set! (. u triangles) (java.util.ArrayList. triMap)) 
        (set! (. u points) (java.util.ArrayList. (flatten pointMap)))
        (.update u) u)
  )))

(defn fromUnwrap [u]
  (map
    (fn [tri] 
      (map
        (fn [point]
          (callList point x y z))
            (callList tri a b c)))
              (.triangles u)))

(defn -toUnwrap [theParent font faceList] (toUnwrap theParent font faceList))
(defn -fromUnwrap [o] (fromUnwrap o))


