(ns my-chan
  (:import [java.util LinkedList Queue])
  (:require [clojure.core.async.impl.protocols :as impl])
  (:use      [clojure.core.async :as async :only [<! go timeout chan >! tap untap mult  <!!]]))


(+ 1 2)
(def c (chan))
(def m (mult c))

(def d (chan))
(tap m d)


(async/put! c 59)
(go (println (<! d)))


(untap m d)
(go (println (<! d))) ; NOTHING

(put! c 55)

(tap m d)
(go (println (<! d))) ; STILL NOTHING. THE MESSAGE WAS DROPPED




(deftype DroppingBuffer [^LinkedList buf ^long n]
  impl/UnblockingBuffer
  impl/Buffer
  (full? [this]
    false)
  (remove! [this]
    (.removeLast buf))
  (add!* [this itm]
    (when-not (= (.size buf) n)
      (.addFirst buf itm)))
  clojure.lang.Counted
  (count [this]
    (.size buf)))

(defn dropping-buffer [n]
  (DroppingBuffer. (LinkedList.) n))






(def cc (chan (dropping-buffer 1)))


(async/put! cc 9090)

(go (println (<! cc)))




