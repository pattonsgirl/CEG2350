#!/bin/bash

# Define colors for better readability
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}========================================"
echo -e "           SYSTEM SUMMARY"
echo -e "========================================${NC}"

# OS and Kernel
echo -e "${GREEN}[OS/Kernel]${NC}"
echo "Hostname: $(hostname)"
echo "Kernel:   $(uname -sr)"
echo ""

# CPU Info
echo -e "${GREEN}[CPU Info]${NC}"
lscpu | grep -E 'Model name|Socket\(s\)|Core\(s\) per socket|Thread\(s\) per core|CPU MHz'
echo ""

# RAM Usage
echo -e "${GREEN}[RAM Usage]${NC}"
free -h | awk 'NR==1{print "          "$1"        "$2"        "$3} NR==2{print "Mem:    "$2"     "$3"     "$4}'
echo ""

# Disk Space (Root partition)
echo -e "${GREEN}[Disk Space]${NC}"
df -h / | awk 'NR==1{print $1"     "$2"     "$3"     "$5" Usage"} NR==2{print $1"      "$2"      "$3"      "$5}'
echo ""

# GPU Info (Checks for NVIDIA)
echo -e "${GREEN}[GPU Info]${NC}"
if command -v nvidia-smi &> /dev/null; then
    nvidia-smi --query-gpu=name,driver_version,memory.total --format=csv,noheader
else
    # Fallback for general PCI devices if NVIDIA isn't present
    gpu_check=$(lspci | grep -i 'vga\|3d\|display')
    if [ -n "$gpu_check" ]; then
        echo "$gpu_check"
    else
        echo "No dedicated GPU detected via lspci or nvidia-smi."
    fi
fi

echo -e "${BLUE}========================================${NC}"
