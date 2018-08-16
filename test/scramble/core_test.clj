(ns scramble.core-test
  (:require [clojure.test :refer :all]
            [scramble.core :refer :all]))


(deftest scramble
  (testing "from docs"
    (is (scramble? "rekqodlw" "world"))
    (is (scramble? "cedewaraaossoqqyt" "codewars"))
    (is (not (scramble? "katas" "steak"))))
  (testing "edge cases"
    (is (not (scramble? "a" "ab")))
    (is (not (scramble? "aa" "bb")))
    (is (not (scramble? "a" "aa")))
    (is (scramble? "ab" ""))
    (is (scramble? "aa" "a"))
    (is (scramble? "abab" "ba"))))

(deftest validator
  (testing "scramble params"
    (is (valid? alphabet "asdf"))
    (is (not (valid? alphabet nil)))
    (is (not (valid? alphabet "ASDF")))
    (is (not (valid? alphabet "1234")))))
