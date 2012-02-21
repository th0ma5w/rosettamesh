(ns rosettamesh.anar
  (:gen-class 
    :name rosettamesh.anar
    :methods [#^{:static true}[toAnar [Object] anar.Obj]
                     #^{:static true}[fromAnar [anar.Obj] Object]])
  (:use rosettamesh.util))

(import '(anar Pt Pts Face Anar Obj))

(defn toAnar [faceList]
  (doto (Obj.) (.addAllFaces (java.util.ArrayList. (map (fn [[a b c]]
      (Face. (Pts. a b c)))
    (map (fn [face]
        (map (fn [[x y z]]
            (Anar/Pt x y z)) face)) faceList) )))))

(defn fromAnar [obj]
  (map (fn [face]
    (map (fn [point]
      (callList point x y z)) 
        (.ptList face))) 
          (.faces obj)))

(defn -fromAnar [o] (fromAnar o))
(defn -toAnar [o] (toAnar o))

