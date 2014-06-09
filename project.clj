(defproject clj-sandbox "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [shodan "0.3.0"]
                 [com.cemerick/piggieback "0.1.3"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [compojure "1.1.6"]]
  :plugins [[lein-ring "0.8.10"]
            [lein-cljsbuild "1.0.3"]]
  :ring {:handler clj-sandbox.handler/app}
  :cljsbuild {
              :builds {:dev {
                             :source-paths ["src-cljs"]
                             :compiler {
                                        :output-to "resources/public/js/main.js"
                                        :optimizations :whitespace
                                        :pretty-print true}}}}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
