(ns scramble.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.util.response :refer :all]))

(def alphabet "abcdefghijklmnopqrstuvwxyz")

(defn scramble? [s1 s2]
  "true if a portion of s1 characters can be rearranged to match s2"
  (let [alphabet-count (zipmap (seq alphabet) (repeat 0))
        allowed-count (merge-with + alphabet-count (frequencies s1))]
    (every? (complement neg?)
            (vals (merge-with - allowed-count (frequencies s2))))))

(defn valid? [allowed s]
  "checks if string consist of allowed characters"
  (and (some? s)
       (some? (re-find (re-pattern (str "^[" allowed "]*$")) s))))

(defroutes scramble-routes
  (GET "/scramble" [s1 s2]
       (if (= true
              (valid? alphabet s1)
              (valid? alphabet s2))
         (response {:scramble (scramble? s1 s2)})
         (status (response {}) 400)))
  (route/not-found (not-found (response {}))))

(def webapp
  (-> scramble-routes
      wrap-params
      (wrap-cors :access-control-allow-origin #"http://localhost:3449"
                 :access-control-allow-methods [:get])
      wrap-json-response))
