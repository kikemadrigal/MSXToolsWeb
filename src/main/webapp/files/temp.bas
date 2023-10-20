10 hola mnod
1 'est es un comentario
20 print "no hay nada"
1 'Esto es otro comentario'
1 'inkey$ ofrece el valor correspondiente a la tecla pulsada y cadena nula (-1) en caso de o haber pulsado ninguna tecla
1 '1000 if inkey$="" then goto 1000 y '
1 'stick(N) ofrece la dirección de las teclas cursor y de los joysticks, cuando N=0 ofrece los cursores, cuando N=1 la del joystick 1'
1 'Si escribimos STICK(0)ORSTICK(1) combinamos los cursores y el joystick'
1 'Para conyinuar depués de pulsar el espacio:150 IF NOT STRIG(0) THEN 150'


1 'Juan Morales utiliza el on stick(0) goto'
1 'Raul portales utiliza stick(0) if st=1 then, if st=3 then..'



10 screen 5,2:defsng a-z:color 1,15,15: open "grp:" as #1
1 'escribimos los sprites'
20 gosub 15000
1 'Inicializamos variables sprite'
30 gosub 10000