(ns cljs-explore.me
  (:require [cljs.core.async :refer [<! close! untap tap chan put!]]
            [shodan.console :as console :include-macros true])
  (:use-macros [cljs.core.async.macros :only [go]]
               [shodan.console :only [with-profile with-group-collapsed]]))

(enable-console-print!)

(print "me")
