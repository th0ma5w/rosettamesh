(ns rosettamesh.util)

(defmacro callList [o & args] (cons 'list(map (fn [x] (list '. o x)) args )))
(defn cleanNil [l] (remove #(= %1 nil) l))

(defn unwind [strips]
  (loop [buffer strips idx (range (count strips)) triangles []]
    (if (> (count buffer) 2)
      (if (even? (first idx))
        (recur (rest buffer) (rest idx) 
          (concat triangles (list ((fn [[a b c]] [a b c]) (take 3 buffer)))))
        (recur (rest buffer) (rest idx) 
          (concat triangles (list ((fn [[a b c]] [b a c]) (take 3 buffer)))))
    ) triangles )))

(defn wind [strips]
  (distinct (apply concat strips)))

