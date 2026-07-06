#include <stdio.h>
#include <dirent.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

static int char_compare(const void *a, const void *b)
{
    return strcmp(*(const char **)a, *(const char **)b);
}

int main(int argc, char const *argv[])
{
    DIR *dir;
    struct dirent *entry;

    int size = 5;
    char **files = malloc(size * sizeof(char *));
    int i = 0;

    if (argc < 2)
    {
        dir = opendir(".");
    }
    else
    {
        dir = opendir(argv[1]);
    }

    if (dir == NULL)
    {
        if (ENOENT == errno)
        {
            fprintf(stderr, "Directory does not exist\n");
        }
        else if (EACCES == errno)
        {
            fprintf(stderr, "Permission denied\n");
        }
        else if (ENOTDIR == errno)
        {
            fprintf(stderr, "Not a directory\n");
        }
        else
        {
            fprintf(stderr, "Unknown error when opening directory: %s\n", strerror(errno));
        }
        return 1;
    }

    while ((entry = readdir(dir)) != NULL)
    {
        files[i] = malloc(strlen(entry->d_name) + 1);
        strcpy(files[i], entry->d_name);
        i++;

        if (i >= size)
        {
            size *= 2;
            files = realloc(files, size * sizeof(char *));
        }
    }
    closedir(dir);

    qsort(files, i, sizeof(char *), char_compare);

    printf("Files:\n");
    for (int j = 0; j < i; j++)
    {
        printf("%s\n", files[j]);
    }

    return 0;
}
