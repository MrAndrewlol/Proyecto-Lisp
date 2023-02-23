#lang racket

(define (celcius_a_faren n)
  
      (if (and (>= n -287)(<= n 100)) (+ 32 (* n 1.8 )) (+ n 0))

        )

(display (celcius_a_faren 20))


(define (faren_a_celcius n)
  
      (if (and (>= n -459)(<= n 212)) (* 0.566 (- n 32 )) (+ n 0))

        )
(newline)
(display (faren_a_celcius 5))
