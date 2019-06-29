import math
def get_points(n_points, n_dim, min_d):
    square_side = min_d
    sphere_radius = math.sqrt(n_points * math.pow(square_side)/(4*math.pi))
    for i in xrange(n_points):
        

if __name__ == '__main__':
    n_points = 10
    n_dim = 3
    min_d = 4
    get_points(n_points, n_dim, min_d)