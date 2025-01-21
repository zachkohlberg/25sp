int x = 5;
int y = 2;

// integer division will result in a quotient of 2

println(x / y);

// if we convert one of our integers to a double before dividing, then we'll
// get a result of 2.5 instead

println((double)x / y);

// both of these will print 2.0 because we performed integer division before
// converting the result to a double

// type cast after division
println((double)(x / y));

// implicit conversion via assignment to a double after division
double z = x / y;
println(z);
