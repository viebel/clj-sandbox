(ns clj-sandbox.me
  (:require [cljs.core.async :refer [<! close! untap tap chan put!]]
            [klozzer.core :refer [new-storage]]
            [goog.net.XhrIo :as goognet]
            [cljs-time.format :as f]
            [cljs-time.core :as t]
            [cljs-time.coerce :as c]
            [klozzer.protocols :refer [IFileSystem -write -read -url -file -file-entry]]
            [shodan.console :as console :include-macros true])
  (:use-macros [cljs.core.async.macros :only [go]]
               [purnam.core :only [? ! def.n obj !>]]
               [shodan.console :only [with-profile with-group-collapsed]]))

(enable-console-print!)


(defn get-url [url]
  (print "get-url:" url)
  (let [c (chan)]
    (let [xhr (js/XMLHttpRequest.)]
      (!> xhr.open "GET" url true)
      (! xhr.responseType "text")
      (! xhr.onreadystatechange (fn [e]
                                  (print "Last-Modified" (!> xhr.getResponseHeader "Last-Modified"))
                                  (print (? e.target))))
      (! xhr.onload (fn [e]
                       (put! c (? e.target.response))))
      (!> xhr.send))
    c))

(def flac "http://audyx.s3.amazonaws.com/Listes%20d'audiom%C3%A9trie%20vocale/audyx/Nombres/Nombres_01.flac")
(def txt "http://audyx.s3.amazonaws.com/Listes%20d'audiom%C3%A9trie%20vocale/audyx/Nombres/Nombres_01.txt")
(print "you")
(print "f: " (f/format "Wed, 11 Jun 2014 08:34:51 GMT"))
(print "now:" (c/from-date (js/Date.)))

(go (let [fs (<! (new-storage 100000000))
          filename "rafi5.txt"
          data (<! (get-url txt))
          file (<! (-file fs filename))]
      (when file (print "lastModifiedDate" (? file.lastModifiedDate)))
      (time (<! (-write fs filename data)))
      (print "writing is done")
      (print "url:" (<! (get-url (<! (-url fs filename)))))
      (print "read:" (<! (-read fs filename "text")))))
