(ns user
  (:use
               [clojure.core.async :only [<! go timeout chan >!]]))


(def a (map #(* % 2)))


(transduce a + 0  (range 4))

(into [] a (range 4))


(chan 1 a)

(chan 1 (comp (map #(.-keyCode %))
                  (filter #{37 39})
                  (map {37 :previous 39 :next})))
