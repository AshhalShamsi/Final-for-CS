module mt240() {
	n=1/160;
	h1=995;
	h2=105;
	d1=500;
	d2=560;
	d3=580;
	offset=1000;
	R1=offset+(d1/2);
	R2=offset+(d2/2);
	Rad=100;
	fnf=200;
	scale([n,n,n]) difference() {
		union() {
			difference() {
				intersection() {
					translate([offset,0,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
					translate([-offset,0,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
					translate([0,offset,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
					translate([0,-offset,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
				}
				translate([-d1/2,0,0]) rotate([0,45,0]) cube([2*Rad,d2,2*Rad], center=true);
			}
			translate([0,0,h1+(h2/4)]) cube([d3,d3,h2/2], center=true);
			translate([0,0,h1+(h2*3/4)]) cube([d3*0.8,d3*0.8,h2/2], center=true);
			translate([d1/4,d1/2.5,h1+h2]) cube([100,30,h2/2], center=true);
			translate([d1/4,-d1/2.5,h1+h2]) cube([100,30,h2/2], center=true);

			translate([-(d1/2-(Rad)),d1/2,Rad]) rotate([90,0,0]) cylinder(h=50,r1=Rad, r2=Rad, center=true, $fn=fnf);
			translate([-(d1/2-(Rad)),-d1/2,Rad]) rotate([90,0,0]) cylinder(h=50,r1=Rad, r2=Rad, center=true, $fn=fnf);

			translate([-(d1/1.75),0,h1*1.03]) rotate([90,0,0]) cylinder(h=d1,r1=30, r2=30, center=true, $fn=fnf);
		}
	}	
}

module mt240_over() {
	n=1/160;
	h1=995;
	h2=205;
	d1=500;
	d2=560;
	d3=640;
	offset=1000;
	R1=offset+(d1/2);
	R2=offset+(d2/2);
	Rad=100;
	fnf=200;
	scale([n,n,n]) difference() {
		union() {
			difference() {
				intersection() {
					translate([offset,0,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
					translate([-offset,0,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
					translate([0,offset,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
					translate([0,-offset,h1/2]) cylinder(h=h1,r1=R1, r2=R2, center=true, $fn=fnf);
				}
				translate([-d1/2,0,0]) rotate([0,45,0]) cube([2*Rad,d2,2*Rad], center=true);
			}
			translate([0,0,h1+(h2/4)]) cube([d3,d3,h2/2], center=true);
			translate([0,0,h1+(h2*3/4)]) cube([d3*0.7,d3*0.7,h2/2], center=true);
			translate([d1/4,d1/2.8,h1+h2]) cube([100,60,h2/2], center=true);
			translate([d1/4,-d1/2.8,h1+h2]) cube([100,60,h2/2], center=true);

			translate([-(d1/2-(Rad)),d1/2,Rad]) rotate([90,0,0]) cylinder(h=100,r1=Rad, r2=Rad, center=true, $fn=fnf);
			translate([-(d1/2-(Rad)),-d1/2,Rad]) rotate([90,0,0]) cylinder(h=100,r1=Rad, r2=Rad, center=true, $fn=fnf);

			translate([-(d2/1.75),0,h1*1.03]) rotate([90,0,0]) cylinder(h=d1,r1=60, r2=60, center=true, $fn=fnf);
		}
	}	
}


mt240_over();