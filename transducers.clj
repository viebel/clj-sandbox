(ns transducers
  (:use [clojure.core.async :only [<! go timeout chan >! put! <!!]]))


(def a (map #(* % 2)))


(transduce a + 0  (range 4))

(into [] a (range 4))


(def c
(chan 1 a))

(def cc
(chan 1 (comp (map #(.-keyCode %))
                  (filter #{37 39})
                  (map {37 :previous 39 :next}))))



(put! cc 5)

(<!! cc)

(put! c 19)

(<! c)

