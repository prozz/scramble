(ns scramble.core-test
  (:require [clojure.test :refer :all]
            [scramble.core :refer :all]))


(deftest scramble
  (testing "scramble from docs"
    (is (scramble? "rekqodlw" "world"))
    (is (scramble? "cedewaraaossoqqyt" "codewars"))
    (is (not (scramble? "katas" "steak")))))
