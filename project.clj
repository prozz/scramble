(defproject scramble "0.1.0-SNAPSHOT"
  :description "scramble challenge"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring "1.6.1"]
                 [compojure "1.6.1"]
                 [ring/ring-json "0.4.0"]]
  :plugins [[lein-ring "0.12.4"]]

  :ring {:handler scramble.core/webapp}

  :main ^:skip-aot scramble.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
