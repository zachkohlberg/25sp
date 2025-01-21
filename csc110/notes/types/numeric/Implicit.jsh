// moving down the list implicitly
byte a = 10;
short b = a;
int c = b;
long d = c;
float e = d;
double f = e;

println(a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f);

// using mixed types in an expression will implicitly convert to the wider type

int x = 5;
double y = 2.0;

// the expression "x / y" results in a double because, of the two types
// involved, double is the wider type

double z = x / y;

// if we changed z's type to int then we would get an error
// int z = x / y;

// will print 2.5
println(z);
