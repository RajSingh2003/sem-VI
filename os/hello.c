#include<stdio.h>
#include<stdlib.h>
#include<mpi.h>

int main(int argc, char** argv) {
MPI_Init(NULL,NULL);
int world_size;
int world_rank;
MPI_Comm_size(MPI_COMM_WORLD, &world_size);
MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);
char processor_name[MPI_MAX_PROCESSOR_NAME];

int name_len;
MPI_Get_processor_name(processor_name, &name_len);

printf("Hello world from processor %s, rank %d out of %d processor\n",processor_name,world_rank,world_size);
MPI_Finalize();
return 0;
}
/*
Hello world from processor pc168.hptrykcs.local, rank 1 out of 2 processor
Hello world from processor pc168.hptrykcs.local, rank 0 out of 2 processor
*/
