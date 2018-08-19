
import random
from numpy import *
import numpy as np;
from plotGauss2D import *
import em_test as em
import question1 as q1
import pylab as pl

def generateData(fileName):
    return loadtxt("data/"+fileName+'.txt');


def euclidinDistance(x,y):
    return np.linalg.norm(x-y);



def kMeans(x,k,iter):
    centres = x[np.random.randint(len(x-1),size=k)]
    value = []
    clusters={}
    for i in range(iter):
        for j in range(len(x)):
            dist = {}
            for c in range(k):
                dist[c] = euclidinDistance(x[j],centres[c]);
            minIndex = min(dist,key=dist.get)
            value = [minIndex,x[j],centres[minIndex]]
            centres[minIndex] = np.array(x[j]+centres[minIndex])/2

            #for last iteration
            if(i== iter-1):
                if minIndex not in clusters:
                    clusters[minIndex] = [x[j]]
                else:
                    clusters.get(minIndex).append(x[j])

    return clusters,centres



def getMean(value):
    mu =[value[0][2]]
    for i in range(len(value)):
        flag = False;
        for j in range(len(mu)):
            if(value[i][2][0]==mu[j][0] and value[i][2][1]==mu[j][1]):
                flag =True;
        if(flag==False):
            mu.append(value[i][2]);
    return mu

def plotClusters(clusters,centres):
    colors = ['r','g','b','k','c']
    for c in clusters:
        for values in clusters[c]:
           pl.scatter(values[0], values[1],color=colors[c])
    for c in centres:
        pl.scatter(c[0], c[1], marker='x', s=100)
    pl.show()




print('///////////////////////////////////////////////////////')

def computeEMwithKMeans(x,m,iterations,dataset):
    clusters, centers = kMeans(x, m, iterations)
    pip = []
    for i in clusters:
        pip.append(len(clusters[i]) / len(x))
    #plotClusters(clusters, centers)
    pi, mu, var = q1.generateRandomParams(x, m)
    logLikeliHood, new_pi, new_mu, new_var, r = q1.getEM(x, pip, centers, var, m)
    print('Dataset: ', dataset, ' for k = ', m)
    print('logLikeliHood using K-means : ', logLikeliHood)
    em.plotMOG(x, em.getPlottingParams(X, new_pi, new_mu, new_var, m))

if __name__== "__main__":

    print('Question 2')
    noOfIterations=100
    #
    # print("###################### M=2 #########################")
    mClusters = 1
    # X = generateData('data_1_small');
    # computeEMwithKMeans(X,mClusters,noOfIterations,'data_1_small')
    #
    # X = generateData('data_2_small');
    # computeEMwithKMeans(X,mClusters,noOfIterations,'data_2_small')
    #
    # X = generateData('data_3_small');
    # computeEMwithKMeans(X,mClusters,noOfIterations,'data_3_small')
    #
    # X = generateData('data_1_large');
    # computeEMwithKMeans(X,mClusters,noOfIterations,'data_1_large')
    #
    # X = generateData('data_2_large');
    # computeEMwithKMeans(X,mClusters,noOfIterations,'data_2_large')
    #
    # X = generateData('data_3_large');
    # computeEMwithKMeans(X,mClusters,noOfIterations,'data_3_large')

    X = generateData('mystery_1');
    computeEMwithKMeans(X,mClusters,noOfIterations,'mystery_1')

    X = generateData('mystery_2');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_2')
    #
    # print("###################### M=3 #########################")
    mClusters = 2
    # X = generateData('data_1_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_small')
    #
    # X = generateData('data_2_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_small')
    #
    # X = generateData('data_3_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_small')
    #
    # X = generateData('data_1_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_large')
    #
    # X = generateData('data_2_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_large')
    #
    # X = generateData('data_3_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_large')
    #
    X = generateData('mystery_1');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_1')

    X = generateData('mystery_2');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_2')
    # print("###################### M=4 #########################")
    mClusters = 3
    # X = generateData('data_1_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_small')
    #
    # X = generateData('data_2_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_small')
    #
    # X = generateData('data_3_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_small')
    #
    # X = generateData('data_1_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_large')
    #
    # X = generateData('data_2_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_large')
    #
    # X = generateData('data_3_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_large')
    X = generateData('mystery_1');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_1')

    X = generateData('mystery_2');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_2')
    #print("###################### M=4 #########################")
    mClusters = 4
    # X = generateData('data_1_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_small')
    #
    # X = generateData('data_2_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_small')
    #
    # X = generateData('data_3_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_small')
    #
    # X = generateData('data_1_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_large')
    #
    # X = generateData('data_2_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_large')
    #
    # X = generateData('data_3_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_large')
    X = generateData('mystery_1');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_1')

    X = generateData('mystery_2');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_2')

    # print("###################### M=4 #########################")
    mClusters = 5
    # X = generateData('data_1_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_small')
    #
    # X = generateData('data_2_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_small')
    #
    # X = generateData('data_3_small');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_small')
    #
    # X = generateData('data_1_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_1_large')
    #
    # X = generateData('data_2_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_2_large')
    #
    # X = generateData('data_3_large');
    # computeEMwithKMeans(X, mClusters, noOfIterations, 'data_3_large')
    X = generateData('mystery_1');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_1')

    X = generateData('mystery_2');
    computeEMwithKMeans(X, mClusters, noOfIterations, 'mystery_2')