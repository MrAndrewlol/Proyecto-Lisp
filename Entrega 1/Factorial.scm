
(define (factorial n)
  (if (= n 0)
  1
  (* n (factorial (- n 1)))))
(define s 0)

(display "Por favor ingresar un numero para realizar el factorial ")
(set! s (read))
 

(display "El numero factorial es: ")
(display (factorial s))

