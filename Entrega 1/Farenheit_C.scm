
(define celcius 1.8)
(define faren 0.566)

(define (celcius_a_faren n)
  
      (if (and (>= n -287)(<= n 100)) (+ 32 (* n celcius )) (+ n 0))

        )

(define (faren_a_celcius n)
  
      (if (and (>= n -459)(<= n 212)) (* 0.566 (- n 32 )) (+ n 0))

        )

(display "Por favor ingresar grados en Celcius: ")
(define x (read))
(display "Por favor ingresar grados en Farenheit ")
(define s (read))
'(newline)


(display "La conversion entre Celcius y Farenheit es de: ")
(display (celcius_a_faren x))
(newline)
(display "La conversion entre Farenheit y Celcius es de: ")
(display (faren_a_celcius s))
