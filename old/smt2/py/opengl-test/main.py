from OpenGL.GLUT import *
from OpenGL.GL import *
import sys

def draw():
    glColor3f(1,1,1)
    glPointSize(10)

    glBegin(GL_POINTS)
    glVertex2f(0,0)
    glVertex2f(0.5,0)
    glEnd()
    glFlush()

glutInit(sys.argv)
glutInitWindowSize(500,500)
glutInitWindowPosition(100,100)
glutCreateWindow("OpenGL Program Ivan Rio")
glutDisplayFunc(draw)
glutMainLoop()