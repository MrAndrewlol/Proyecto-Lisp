
(define (fibonacci n)
  (if (<= n 2)
      1
      
      (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))


(display "Por favor ingresar el numero deseado: ")
(define x (read))


(display "el numero de Fibonacci es de: ")
(display (fibonacci x))
