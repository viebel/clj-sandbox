(ns bardo.features
  (require [bardo.ease :refer [wrap ease shift clamp]]
           [bardo.interpolate :refer [interpolate into-lazy-seq mix blend chain pipeline]]
           [bardo.transition :refer [transition]]))



(def times [0 0.5 0.9 1])

;; primatives
(map (interpolate 0 10) times)
;; => (0 5.0 10)

;; sequences
(map (interpolate [0 1] [5 9]) times)

(map (interpolate {:a 0 :b 1} {:a 5 :b 0}) times)

;; different dimensions
(map (interpolate [0] [5 9]) times)
