(ns rosettamesh.processing
  (:gen-class 
    :name rosettamesh.processing
    :methods [#^{:static true}[toProcessing [Object] java.util.ArrayList]
                     #^{:static true}[fromProcessing [java.util.ArrayList] Object]])
  (:use rosettamesh.util))

(import '(processing.core PVector))

(defn toProcessing [faceList]
  (java.util.ArrayList. (map (fn [face]
    (java.util.ArrayList. (map (fn [[x y z]]
      (PVector. x y z)) 
        face))) faceList)))

(defn fromProcessing [obj]
  (map (fn [face]
    (map (fn [pvector]
        (callList pvector x y z))
          face))
            obj))

(defn -fromProcessing [o] (fromProcessing o))
(defn -toProcessing [o] (toProcessing o))

