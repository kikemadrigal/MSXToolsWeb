10screen5,2:defsnga-z:color1,15,15:open"grp:"as#1
20gosub15000
30gosub10000
100gosub7000
110putspritepp,(px,py),pc,ps
120gosub9000
130goto100
1000k$=inkey$
1005k=val(k$)
1010ifpa=1thenpy=py-pl
1020ifpy<po-20thenpl=-pl
1030ifpy>pothenpy=po:pl=-pl:pa=0
1040ifk$="a"thenpy=py+pv
1060ifk$="p"thenpx=px+pv
1070ifk$="o"thenpx=px-pv
1990return
2000onstick(0)goto2200,2400,2600,2000,3000,3200,3400,3600
2010ifpa=1thenpy=py-pl
2020ifpy<po-20thenpl=-pl
2030ifpy>pothenpy=po:pl=-pl:pa=0
2040goto3900
2200ifpa<>1thenpo=py:pa=1:goto3900
2400px=px+pv:ifpa<>1thenpa=1:goto3900
2600px=px+pv:goto3900
3400px=px-pv:goto3900
3600px=px-pv:ifpa<>1thenpa=1:goto3900
3900return
4000j=stick(0)
4010ifpa=1thenpy=py-pl
4020ifpy<po-20thenpl=-pl
4030ifpy>pothenpy=po:pl=-pl:pa=0
4040ifj=1thenifpa<>1thenpo=py:pa=1
4050ifj=2thenpx=px+pv:ifpa<>1thenpa=1
4060ifj=3thenpx=px+pv
4070ifj=7thenpx=px-pv
4080ifj=8thenpx=px-pv:ifpa<>1thenpa=1
4990return
5000onstick(0)gosub5200,5400,5600,5800,6000,6200,6400,6600
5100ifpa=1thenpy=py-pl
5120ifpy<po-20thenpl=-pl
5130ifpy>pothenpy=po:pl=-pl:pa=0
5190return
5200ifpa<>1thenpo=py:pa=1
5290return
5400ifpa<>1thenpa=1
5410px=px+pv
5490return
5600px=px+pv
5690return
5800'nada'
5890return
6000'nada'
6090return
6200'nada'
6290return
6400px=px-pv:'gosub9000
6490return
6600ifpa<>1thenpa=1
6610px=px-pv:'gosub9000
6690return
7000st=stick(0):px=px-(st=3andpx<247)*pv+(st=7andpx>0)*pv:py=py-(st=5andpy<192)*pl+(st=1andpy>0)*pl
7990return
9000line(0,180)-(256,212),15,bf
9060preset(0,186):print#1,time
9070time=0
9090return
10000px=10*8:py=20*8:pw=16:ph=16:pv=8:pl=8:po=py:pa=0
10030pc=6:pp=0:ps=0
10090return
15000forj=1to32:reada$
15020sp$=sp$+chr$(val(a$))
15030nextj
15040sprite$(0)=sp$
15060return
15120DATA255,255,255,255,255,255,255,255
15130DATA255,255,255,255,255,255,255,255
15140DATA255,255,255,255,255,255,255,255
15150DATA255,255,255,255,255,255,255,255
