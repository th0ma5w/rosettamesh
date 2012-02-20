(ns rosettamesh.util)

(defmacro callList [o & args] (cons 'list(map (fn [x] (list '. o x)) args )))
(defn cleanNil [l] (remove #(= %1 nil) l))

