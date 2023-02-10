(defun fibonacci (N)
    "Coso"
    (if (or (zerop N) (= N 1))
        1
        (let
            ((F1 (fibonacci (- N 1)))
             (F2 (fibonacci (- N 2))))
            (+ F1 F2))))


(print(fibonacci 5))


(defun factorial (n)
    "Coso"
  (if (= n 0)
      1
      (* n (factorial (- n 1))) ) )
