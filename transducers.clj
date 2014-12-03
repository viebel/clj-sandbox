(ns transducers
  (:use [clojure.core.async :only [<! go timeout chan >! put! <!!]]))


(def a (map #(* % 2)))

(def f (filter even?))
(def g (filter (partial < 0)))


(comp f g)

(transduce (comp f g)  + 0 [1 2 3 -1 -2] )


(into [] (comp f g)  [1 2 3 10  -1 -2] )

(sequence f  [1 2 3 10  -1 -2] )

(sequence (comp f g)  [1 2 3 10  -1 -2])




(transduce a + 0 (range 4))



((comp #(* 2 %) #(+ 100 %)) 18)


(def c (chan 1 (comp f a)))

(def cc (chan 1 (comp
                 (filter #{37 39})
                 (map {37 :previous 39 :next}))))


(go
 (<! (timeout 5000))
 (println "done"))

(def d (chan))


(put! cc 37)
(go
 (println (<! cc)))



(put! c 19)
(put! c 20)



(go
 (println (<! c)))
