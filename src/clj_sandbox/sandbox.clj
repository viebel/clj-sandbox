(ns clj-sandbox.sandbox)

(+ 2 1 2)

(empty {})



(ancestors (class (clojure.lang.MapEntry. "a" 1)))



(class
 (empty []))

(class
 (first (mapv identity (range 3))))

(mapv identity {:fooa 5})


(class
(first {:foo 5}))


(empty (first {:foo 5}))


(class
(first (mapv identity {:foo 5})))


(empty (first (mapv identity {:foo 5})))

(empty '())

(mapv identity (range 2))

(map identity (range 2))
