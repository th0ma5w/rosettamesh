(ns rosettamesh.igeo
  (:gen-class 
    :name rosettamesh.igeo
    :methods [#^{:static true}[toIgeo [Object] java.util.ArrayList]
                     #^{:static true}[fromIgeo [java.util.ArrayList] Object]])
  (:use rosettamesh.util))

(import '(processing.core PVector))

(defn toIgeo [faceList]
)

(defn fromIgeo [obj]
)

(defn -fromIgeo [o] (fromIgeo o))
(defn -toIgeo [o] (toIgeo o))

